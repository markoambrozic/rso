/*
 *  Copyright (c) 2014-2017 Kumuluz and/or its affiliates
 *  and other contributors as indicated by the @author tags and
 *  the contributor list.
 *
 *  Licensed under the MIT License (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  https://opensource.org/licenses/MIT
 *
 *  The software is provided "AS IS", WITHOUT WARRANTY OF ANY KIND, express or
 *  implied, including but not limited to the warranties of merchantability,
 *  fitness for a particular purpose and noninfringement. in no event shall the
 *  authors or copyright holders be liable for any claim, damages or other
 *  liability, whether in an action of contract, tort or otherwise, arising from,
 *  out of or in connection with the software or the use or other dealings in the
 *  software. See the License for the specific language governing permissions and
 *  limitations under the License.
*/
package com.kumuluz.ee.samples.microservices.simple;

import org.json.JSONObject;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/info")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InfoResource {

    @PersistenceContext
    private EntityManager em;

    /**
     * <p>Queries the database and returns a list of all books.</p>
     *
     * @return Response object containing the retrieved list of books from the database.
     */
    @GET
    public Response getInfo() {
        JSONObject obj = new JSONObject();

        obj.put("clani", new String[] {"ma6794", "dm9929"});
        obj.put("opis_projekta", "Najin projekt implementita plug & play vtičnik za povečanje skalabilnosti in odpornosti na napake monolitnih ecommerce platform");
        obj.put("mikrostoritve", new String[] {"http://35.189.96.118:8081/v1/orders", "http://35.197.209.159:8080/v1/catalog/"});
        obj.put("github", new String[] {"https://github.com/markoambrozic/catalog", "https://github.com/markoambrozic/orders"});
        obj.put("travis", new String[] {"https://travis-ci.org/jmezna/rso-customers", "https://travis-ci.org/jmezna/rso-orders"});
        obj.put("dockerhub", new String[] {"https://hub.docker.com/r/jmezna/rso-customers/", "https://hub.docker.com/r/jmezna/rso-orders/"});

        return Response.ok(obj.toString()).build();
    }
}
