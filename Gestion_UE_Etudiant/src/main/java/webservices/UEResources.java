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


    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response addUe(UniteEnseignement ue)
    {
        if(helper.addUniteEnseignement(ue))
        { return Response.status(201).etity("added successfully")}
        else {return Response.status(409).entity("already exist")}
    }


    //delete
    @Path("/delete/{code}")
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteUE(@PathParam("code") int code){
        if(helper.addUniteEnseignement(code)) {
            return Response
                    .status(200)
                    .entity("deleted")
                    .build();
        } return Response
                .status(404)
                .entity("not found")
                .build();
    }

    //search by code
    @Path("/search")
    @GET
    @Produces(MediaType.APPLUCATION_JSON)
    public Response search(QueryParam(value = "s") int semestre){
        return Response
                .status(200)
                .entity(this.helper.getUEBySemestre(semestre))
                .build();
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
