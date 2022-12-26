package gov.pension.controller;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import gov.pension.common.ApiResponse;
import gov.pension.entity.MstAuthority;
import gov.pension.exception.IFMSException;
import gov.pension.service.MstAuthorityService;

@Path("pension")
public class mstAuthorityController {
	@Inject
	private MstAuthorityService authorityService;

	@Path("/saveMstAuthority")
	@POST
	public Response saveMstAuthority(@RequestBody MstAuthority authority) throws IFMSException {
		MstAuthority rateService = authorityService.saveMstAuthority(authority);
		return Response.ok(ApiResponse.success(rateService)).build();
	}
}