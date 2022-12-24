package gov.pension.controller;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import gov.pension.entity.MstDrRate;
import gov.pension.service.MstDrRateService;

@Path("pension")
public class MstDrRateController {

	@Inject
	private MstDrRateService drRateService;
	
	@Path("/saveDrRateService")
	@POST
	public MstDrRate saveDrRateService(@RequestBody MstDrRate drRate) {
		return drRateService.saveMstDrRate(drRate);
	}
}
