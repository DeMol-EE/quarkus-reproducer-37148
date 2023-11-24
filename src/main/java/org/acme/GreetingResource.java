package org.acme;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.container.ResourceContext;
import jakarta.ws.rs.core.Context;

@Path("hello")
@Transactional
@RequestScoped
public class GreetingResource {

    @Path("{id}")
    public SubResource subResource(
            @Context ResourceContext resourceContext
    ) {
        return resourceContext.initResource(CDI.current()
                .select(SubResource.class)
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
