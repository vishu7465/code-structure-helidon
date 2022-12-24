package gov.pension.controller;

import javax.inject.Inject;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import gov.pension.common.ApiResponse;
import gov.pension.entity.MstDrRate;
import gov.pension.exception.IFMSException;
import gov.pension.service.MstDrRateService;

@Path("pension")
public class MstDrRateController {

	@Inject
	private MstDrRateService drRateService;
	
	@Path("/saveDrRateService")
	@POST
	public Response saveDrRateService(@RequestBody MstDrRate drRate)throws IFMSException {
		MstDrRate rateService = drRateService.saveMstDrRate(drRate);
		 return Response.ok(ApiResponse.success(rateService)).build();
	}
}
