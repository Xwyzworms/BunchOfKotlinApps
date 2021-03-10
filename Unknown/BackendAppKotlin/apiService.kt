interface apiService {


    @GET("getData.php")
    fun getData(): Call<ResponseGetData>

    @GET("getData.php")
    fun getDataById(@Query("id") id : String) : Call<ResponseGetData>

    //insert
    @FormUrlEncoded
    @POST("insert.php")
    fun insertData(@Field("nama") nama : String,
                   @Field("nohp") nohp : String,
                   @Field("alamat") alamat : String) : Call<ResponseGetData>
                
    //update
    @FormUrlEncoded
    @POST("update.php")
    fun updateData(@Field("id") id : String,
                   @Field("nama") nama : String,
                   @Field("nohp") nohp : String,
                   @Field("alamat") alamat : String) : Call<ResponseGetData>
            
                   
   @FormUrlEncoded
   @POST("delete.php")
   fun deleteData(@Field("id") id : String) : Call<ResponseGetData> 
    

}