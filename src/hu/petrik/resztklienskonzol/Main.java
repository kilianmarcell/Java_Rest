package hu.petrik.resztklienskonzol;

import jdk.swing.interop.DragSourceContextWrapper;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) {
        String url = "http://localhost/film_db_rest/api/film";
        try {
            Film film = new Film(0, "asd", "Teszt", 121, 7);
            filmHozzaadasa(url, film);
            osszesFilmKiirasa(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void osszesFilmKiirasa(String url) throws IOException {
        URL urlObject = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) urlObject.openConnection();
        conn.setRequestProperty("Accept", "application/json");
        InputStream is = conn.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String sor = br.readLine();
        while (sor != null) {
            System.out.println(sor);
            sor = br.readLine();
        }
        br.close();
        is.close();
    }

    public static void filmHozzaadasa(String url, Film film) throws IOException {
        URL urlObject = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) urlObject.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-type", "application/json");
        conn.setRequestProperty("Accept", "application/json");
        OutputStream os = conn.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8));
    }
}
