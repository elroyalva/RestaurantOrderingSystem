package com.restjersey;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import utility.OrderUtility;

@Path("/placeOrder")
public class PlaceOrder {
	@POST
	@Produces("application/xml")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response placeOrder(InputStream incomingData) {

		StringBuilder json = new StringBuilder();
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
			String line = null;
			while ((line = in.readLine()) != null) {
				json.append(line);
			}
		} catch (Exception e) {
			System.out.println("Error Parsing: - ");
		}
		json.deleteCharAt(json.length() - 1);
		json.deleteCharAt(0);
		String jsonStr = json.toString().replace("\\\"", "\"");

		JSONObject jsonObj = new JSONObject(jsonStr);
		OrderUtility orderUtil = new OrderUtility();
		boolean commit = orderUtil.insertOrder(jsonObj);

		// return HTTP response 200 in case of success
		if(commit){
			return Response.status(200).entity(commit).build();
		}
		return Response.status(404).entity(commit).build();
	}

}