package webservices;

import metiers.UniteEnseignementBusiness;

import javax.ws.rs.Path ;

@Path("/ue") //URI
public class UEResources {

    UniteEnseignementBusiness helper = new UniteEnseignementBusiness();
    @Path("/liste")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response liste()
    {
        return Response.status(200).entity(
                helper.getListeUE()
        ).build() ;
    }


    @Path("/ajout")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response ajout(UniteEnseignement ue)
    {
        if(helper.addUniteEnseignement(ue))
        { return Response.status(201).etity("added successfully")}
        else {return Response.status(409).entity("already exist")}
    }





    @Path("/hello") //
    @GET
    @Produces(Mediatype.TEXT_PLAIN)
    public Response sayHELLO(){
        return Response
                .status(200)
                .entity ("Hello 4infini")
                .build();

    }
}
