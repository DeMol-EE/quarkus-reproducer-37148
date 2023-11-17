package org.acme;

import io.quarkus.arc.Unremovable;
import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.enterprise.context.Dependent;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;

@Unremovable
@RegisterForReflection
@Dependent
public class SubResource {

    @PathParam("id")
    String id;

    @GET
    public String hi(@QueryParam("bar") Integer bar) {
        return "Hello %s %s".formatted(id, bar);
    }
}
