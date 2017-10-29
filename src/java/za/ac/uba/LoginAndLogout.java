/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.uba;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import za.ac.uba.model.CredentialDetails;
import za.ac.uba.model.UserViewModel;

/**
 *
 * @author gracematshiye
 */
public class LoginAndLogout {

    private Gson gson = new Gson();
    private String basicURL = "http://localhost:8080/api";
    
    public UserViewModel login(int username, String password) {
        try {
            CredentialDetails credentialDetails = new CredentialDetails(username, password);
            String input = gson.toJson(credentialDetails);

            Client client = Client.create();
            WebResource webResource = client.resource(basicURL + "/login");
            ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);

            if (response.getStatus() != 200) {
//                System.out.println(response.getEntity(String.class));
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }

            UserViewModel user =  gson.fromJson(response.getEntity(String.class), UserViewModel.class);
            System.out.println(user.getSessionKey());

            return user;

        } catch (RuntimeException e) {
            e.getMessage();
        }
      
        return null;
    }

    public String logout(String key) {
        try {

            Client restClient = Client.create();
            WebResource webResource = restClient.resource(basicURL + "/logout");
            ClientResponse response = webResource.accept("application/json")
                    .header("Content-Type", "application/json")
                    .header("Authorization", key)
                    .get(ClientResponse.class);

            return response.getEntity(String.class);
        } catch (RuntimeException e) {
            e.getMessage();
            return null;
        }

    }
    
}
