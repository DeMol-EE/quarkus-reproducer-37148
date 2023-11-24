package org.acme;

import io.quarkus.arc.Unremovable;
import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.Dependent;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;

@Unremovable
@RegisterForReflection
@Dependent
public class BarResource {

    @PathParam("id")
    String id;

    @GET
    public String hi(@QueryParam("bar") Integer bar) {
        return "Hello %s %s".formatted(id, bar);
    }

    @PostConstruct
    public void hi() {
        System.out.println(">" + this.getClass().getSimpleName());
    }

    @PreDestroy
    public void bye() {
        System.out.println("<" + this.getClass().getSimpleName());
    }
}
