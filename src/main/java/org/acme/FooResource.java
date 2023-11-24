package org.acme;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.container.ResourceContext;
import jakarta.ws.rs.core.Context;

@Path("hello")
@RequestScoped
public class FooResource {

    @Path("{id}")
    public BarResource subResource(
            @Context ResourceContext resourceContext
    ) {
        return resourceContext.initResource(CDI.current()
                .select(BarResource.class)
                .get());
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
