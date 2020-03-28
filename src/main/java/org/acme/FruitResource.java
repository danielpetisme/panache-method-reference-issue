package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

@Path("/fruits")
public class FruitResource {


    @GET
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getFruitName(@PathParam("id") Long id) {
        return Fruit.<Fruit>findByIdOptional(id).map(it -> it.name.toUpperCase()).orElse("Error");
    }

    @GET
    @Path("/with-method-invocation/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getFruitNameWithMethodInvocation(@PathParam("id") Long id) {
        return Optional.of(id).map(it -> Fruit.<Fruit>findById(it)).map(it -> it.name.toUpperCase()).orElse("Error");
    }

    @GET
    @Path("/with-method-reference/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getFruitNameWithMethodReference(@PathParam("id") Long id) {
        return Optional.of(id).map(Fruit::<Fruit>findById).map(it -> it.name.toUpperCase()).orElse("Error");
    }
}