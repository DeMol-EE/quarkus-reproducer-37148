package org.acme;

import jakarta.enterprise.inject.spi.CDI;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.container.ResourceContext;
import jakarta.ws.rs.core.Context;

@Path("hello")
public class GreetingResource {

    @Path("{id}")
    public SubResource subResource(
            @Context ResourceContext resourceContext
    ) {
        return resourceContext.initResource(CDI.current()
                .select(SubResource.class)
                .get());
    }

}
