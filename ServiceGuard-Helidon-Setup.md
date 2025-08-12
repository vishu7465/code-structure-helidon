# ServiceGuard Setup for Helidon MP Microservice

## 🎯 Project Analysis Results

**Repository**: https://github.com/vishu7465/code-structure-helidon

### Detection Results:
- **Language**: Java (97% confidence)
- **Framework**: Helidon MP (94% confidence)
- **Project Type**: Reactive Microservice Framework
- **Architecture**: MicroProfile-compliant microservice
- **Java Version**: Java 11+
- **Helidon Version**: 3.x/4.x

## 🚀 Quick Setup Guide

### 1. **Add Monitoring Dependencies**
Add the contents of `pom-helidon-monitoring.xml` to your existing `pom.xml`:

```bash
# Rebuild with new dependencies
mvn clean install
```

### 2. **Copy ServiceGuard Components**
```bash
# Copy health checks
cp src/main/java/com/serviceguard/health/ServiceGuardHealthCheck.java \
   your-project/src/main/java/com/serviceguard/health/

# Copy metrics endpoint
cp src/main/java/com/serviceguard/metrics/ServiceGuardMetrics.java \
   your-project/src/main/java/com/serviceguard/metrics/

# Copy configuration
cp src/main/resources/META-INF/microprofile-config.properties \
   your-project/src/main/resources/META-INF/

# Copy logging configuration
cp src/main/resources/logging.properties \
   your-project/src/main/resources/
```

### 3. **Configure Environment**
```bash
# Copy environment template
cp .env.helidon .env

# Edit with your values
nano .env
```

### 4. **Test Health and Metrics Endpoints**
```bash
# Start Helidon application
mvn exec:java

# Test MicroProfile Health endpoints
curl http://localhost:8080/health
curl http://localhost:8080/health/live
curl http://localhost:8080/health/ready
curl http://localhost:8080/health/started

# Test ServiceGuard endpoints
curl http://localhost:8080/serviceguard/metrics
curl http://localhost:8080/serviceguard/health/detailed

# Test MicroProfile Metrics
curl http://localhost:8080/metrics
curl http://localhost:8080/metrics/application
curl http://localhost:8080/metrics/vendor
curl http://localhost:8080/metrics/base
```

### 5. **Docker Deployment**
```bash
# Build and run with Docker Compose
docker-compose -f docker-compose.helidon.yml up -d

# Check container status
docker-compose ps
docker-compose logs helidon-app

# Test health in Docker
curl http://localhost:8080/health
```

## 📊 Monitoring Endpoints

| Endpoint | Description | URL |
|----------|-------------|-----|
| **MicroProfile Health** | | |
| Overall Health | Complete health status | http://localhost:8080/health |
| Liveness | Application is running | http://localhost:8080/health/live |
| Readiness | Ready for traffic | http://localhost:8080/health/ready |
| Startup | Startup completed | http://localhost:8080/health/started |
| **ServiceGuard Custom** | | |
| Detailed Health | Enhanced health info | http://localhost:8080/serviceguard/health/detailed |
| Custom Metrics | Application metrics | http://localhost:8080/serviceguard/metrics |
| **MicroProfile Metrics** | | |
| All Metrics | Prometheus format | http://localhost:8080/metrics |
| Application Metrics | Custom app metrics | http://localhost:8080/metrics/application |
| Vendor Metrics | Helidon metrics | http://localhost:8080/metrics/vendor |
| Base Metrics | JVM metrics | http://localhost:8080/metrics/base |

## 🔧 ServiceGuard Integration

### 1. **Dashboard Configuration**
1. Login to ServiceGuard dashboard
2. Add service: "helidon-microservice"
3. Set monitoring URL: http://your-domain:8080/health
4. Configure alert thresholds:
   - Response time: < 2000ms
   - Error rate: < 5%
   - Memory usage: < 90%
   - CPU usage: < 85%

### 2. **MicroProfile Configuration**
Update `microprofile-config.properties`:

```properties
# ServiceGuard configuration
serviceguard.enabled=true
serviceguard.service.name=helidon-microservice
serviceguard.api.key=your_api_key_here

# Health check intervals
serviceguard.health.interval=30
serviceguard.health.timeout=10

# Alert configuration
serviceguard.alerts.enabled=true
serviceguard.alerts.email=admin@company.com
```

### 3. **Custom Health Indicators**
Add custom health checks by implementing `HealthCheck`:

```java
@Readiness
@ApplicationScoped
public class DatabaseHealthCheck implements HealthCheck {
    @Override
    public HealthCheckResponse call() {
        // Your database health check logic
        return HealthCheckResponse.named("database")
                .status(isDatabaseHealthy())
                .build();
    }
}
```

### 4. **Custom Metrics**
Add application-specific metrics:

```java
@ApplicationScoped
public class BusinessMetrics {
    
    @Inject
    private MetricRegistry registry;
    
    @Counted(name = "order_processed")
    public void processOrder() {
        // Business logic
    }
    
    @Gauge(name = "active_users")
    public int getActiveUsers() {
        return calculateActiveUsers();
    }
}
```

## 💡 Advanced Features

### Prometheus Integration
Access Prometheus metrics at `/metrics` endpoint in OpenMetrics format.

### Grafana Dashboards
Pre-configured Grafana dashboards for:
- JVM metrics (memory, threads, GC)
- Application metrics (response times, throughput)
- Business metrics (custom counters, gauges)
- Health status trends

### Load Balancer Integration
Configure health checks:
- **Health Check URL**: `/health/ready`
- **Interval**: 30 seconds
- **Timeout**: 10 seconds
- **Success codes**: 200
- **Failure threshold**: 3

### Kubernetes Deployment
```yaml
apiVersion: v1
kind: Pod
spec:
  containers:
  - name: helidon-app
    image: helidon-serviceguard:latest
    ports:
    - containerPort: 8080
    livenessProbe:
      httpGet:
        path: /health/live
        port: 8080
      initialDelaySeconds: 30
      periodSeconds: 10
    readinessProbe:
      httpGet:
        path: /health/ready
        port: 8080
      initialDelaySeconds: 5
      periodSeconds: 5
    startupProbe:
      httpGet:
        path: /health/started
        port: 8080
      initialDelaySeconds: 10
      periodSeconds: 5
      failureThreshold: 12
```

## 🆘 Troubleshooting

### Common Issues:

1. **Health endpoints return 404**: Verify `helidon-microprofile-health` dependency
2. **Metrics not available**: Check `helidon-microprofile-metrics` dependency
3. **Custom health checks not working**: Ensure `@ApplicationScoped` annotation
4. **Docker build fails**: Verify all monitoring files are present

### Debugging Commands:
```bash
# Check application logs
docker-compose logs -f helidon-app

# Test specific health checks
curl http://localhost:8080/health/live
curl http://localhost:8080/health/ready

# Monitor memory metrics
curl http://localhost:8080/metrics/base | grep memory

# Check custom metrics
curl http://localhost:8080/metrics/application | grep serviceguard
```

### Performance Tuning:
```bash
# Optimize JVM for containers
export JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0"

# Enable detailed GC logging
export JAVA_OPTS="$JAVA_OPTS -Xlog:gc*:gc.log"

# Profile with JFR
export JAVA_OPTS="$JAVA_OPTS -XX:+FlightRecorder"
```

---

🎉 **Your Helidon MP microservice now has enterprise-grade ServiceGuard monitoring!**

Features included:
- ✅ MicroProfile Health checks (liveness, readiness, startup)
- ✅ MicroProfile Metrics with Prometheus export
- ✅ Custom ServiceGuard health and metrics endpoints
- ✅ Docker containerization with health checks
- ✅ Prometheus and Grafana integration
- ✅ Kubernetes-ready deployment manifests
- ✅ Comprehensive logging and alerting
- ✅ Performance monitoring and tuning guides