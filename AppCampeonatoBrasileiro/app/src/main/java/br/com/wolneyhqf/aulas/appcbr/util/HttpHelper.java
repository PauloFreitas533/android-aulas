package br.com.wolneyhqf.aulas.appcbr.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;

/**
 * Created by wolney on 11/04/17.
 */

public class HttpHelper {

    private String urlBase;

    public HttpHelper(String urlBase){
        this.urlBase = urlBase;
    }

    public static boolean hasConnection(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }

    public static boolean isWiFi(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.getType() == ConnectivityManager.TYPE_WIFI);
    }

    public static boolean isMobileData(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.getType() == ConnectivityManager.TYPE_MOBILE);
    }

    public String doGET(String path){
        return doGET(path, null);
    }

    public String doGET(String path, Map<String, String> headers){
        String response = null;
        HttpURLConnection connection = null;
        try {
            URL url = new URL(getFullURL(path));
            connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(10000);
            connection.setConnectTimeout(15000);
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.setDoOutput(false);
            if(headers != null && headers.size()>0){
                for(String key : headers.keySet()){
                    connection.addRequestProperty(key, headers.get(key));
                }
            }
            connection.connect();
            if(connection.getResponseCode() >= HttpURLConnection.HTTP_BAD_REQUEST){
                return null;
            }else{
                InputStream in = connection.getInputStream();
                response = IOUtil.toString(in);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if(connection!=null){
                connection.disconnect();
            }
            return response;
        }
    }

    public String doPOST(String path, Map<String, String> headers, String body){
        String response = null;
        HttpURLConnection connection = null;
        OutputStream os = null;
        BufferedWriter bw = null;
        try {
            URL url = new URL(getFullURL(path));
            connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(10000);
            connection.setConnectTimeout(15000);
            connection.setRequestMethod("POST");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            if(headers != null && headers.size()>0){
                for(String key : headers.keySet()){
                    connection.addRequestProperty(key, headers.get(key));
                }
            }
            os = connection.getOutputStream();
            bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            bw.write(body);
            bw.flush();
            bw.close();
            os.close();
            connection.connect();
            if(connection.getResponseCode() >= HttpURLConnection.HTTP_BAD_REQUEST){
                return null;
            }else{
                InputStream in = connection.getInputStream();
                response = IOUtil.toString(in);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if(connection!=null){
                connection.disconnect();
            }
            return response;
        }
    }

    public String getFullURL(String path){
        return urlBase + "/" + path;
    }

    public void teste(){
        String response = null;
        try {
            URL url = new URL("http://127.0.0.1/appcbr/clubes"); // Endereço do web service
            HttpURLConnection connection = (HttpURLConnection) url.openConnection(); // Obtém instância de HttpURLConnection
            connection.setConnectTimeout(15000); // Tempo limite para tentar se conectar ao web service
            connection.setReadTimeout(10000); // Tempo limite para ler os dados do web services
            connection.setRequestMethod("GET"); // Método HTTP utilizado na requisição
            connection.setDoInput(true); // Se lerá dados da requisição
            connection.setDoOutput(false); // Se escreverá dados na requisição
            connection.addRequestProperty("Content-Type", "application/json"); // Cabeçalhos da requisição
            OutputStream os = connection.getOutputStream(); // Obtém um OutputStream para escrever dados no corpo da requisição
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8")); // Obtém BufferedWriter
            bw.write("Dados da requisição"); // Escreve os dados no corpo da requisição em formato de String (BufferedWriter)
            bw.flush(); // Para o BufferedWriter escrever os dados
            bw.close();  // Fecha o BufferedWriter
            os.close(); // Fecha o OutputStream
            connection.connect(); // Estabelecer conexão
            // Verifica se conexão foi realizada com sucesso
            if(connection.getResponseCode() >= HttpURLConnection.HTTP_BAD_REQUEST){
                // ocorreu algum erro na conexão ao web service
            }else{
                // Se conexão deu certo, obtém o InputStream para ler os dados da requisição
                InputStream in = connection.getInputStream();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void teste2(){
        String response = null;
        try {
            URL url = new URL("http://127.0.0.1/appcbr/clubes"); // Endereço do web service
            HttpURLConnection connection = (HttpURLConnection) url.openConnection(); // Obtém instância de HttpURLConnection
            connection.setConnectTimeout(15000); // Tempo limite para tentar se conectar ao web service
            connection.setReadTimeout(10000); // Tempo limite para ler os dados do web services
            connection.setRequestMethod("GET"); // Método HTTP utilizado na requisição
            connection.setDoInput(true); // Se lerá dados da requisição
            connection.setDoOutput(false); // Se escreverá dados na requisição
            connection.addRequestProperty("Content-Type", "application/json"); // Cabeçalhos da requisição
            connection.connect(); // Estabelecer conexão
            // Verifica se conexão foi realizada com sucesso
            if(connection.getResponseCode() >= HttpURLConnection.HTTP_BAD_REQUEST){
                // ocorreu algum erro na conexão ao web service
            }else{
                // Se conexão deu certo, obtém o InputStream para ler os dados da requisição
                InputStream in = connection.getInputStream();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
