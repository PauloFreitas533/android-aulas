package br.com.wolneyhqf.aulas.appcbr.resource;

import java.util.List;

import br.com.wolneyhqf.aulas.appcbr.model.Clube;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by wolney on 04/04/17.
 */

public interface ClubeResource {

    @GET("clubes")
    Call<List<Clube>> getList();

}
