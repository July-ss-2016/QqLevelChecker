package vip.creeper.programs.qqlevelchecker;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by July_ on 2017/10/14.
 */
public class HttpUtil {
    public static String sendGet(final String url, final String cookie) {
        StringBuilder result = new StringBuilder();
        BufferedReader in = null;

        try {
            URL realUrl = new URL(url);
            URLConnection connection = realUrl.openConnection();

            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.setRequestProperty("cookie", cookie);
            connection.connect();

            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;

            while ((line = in.readLine()) != null) {
                result.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return result.toString();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        return result.toString();
    }

    public static String sendPost(final String url, final String param, final String cookie) {
        PrintWriter out = null;
        BufferedReader in = null;
        StringBuilder result = new StringBuilder();

        try {
            URL realUrl = new URL(url);
            URLConnection connection = realUrl.openConnection();

            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.setRequestProperty("cookie", cookie);
            connection.setDoOutput(true);
            connection.setDoInput(true);

            out = new PrintWriter(connection.getOutputStream());

            out.print(param);
            out.flush();

            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;

            while ((line = in.readLine()) != null) {
                result.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }

                if (in != null) {
                    in.close();
                }
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }

        return result.toString();
    }

    public static String getWebsiteSource(final String url, final String cookie) throws Exception  {
        HttpURLConnection conn = (HttpURLConnection)(new URL(url)).openConnection();

        conn.setRequestMethod("GET");
        conn.setRequestProperty("accept", "*/*");
        conn.setRequestProperty("connection", "Keep-Alive");
        conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
        conn.setRequestProperty("cookie", cookie);
        conn.setConnectTimeout(5 * 1000);

        InputStream inStream =  conn.getInputStream();
        byte[] data = readInputStream(inStream);

        return new String(data);
    }

    private static byte[] readInputStream(final InputStream input) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[]  buffer = new byte[1204];
        int len;

        while ((len = input.read(buffer)) != -1){
            outStream.write(buffer,0,len);
        }

        input.close();
        return outStream.toByteArray();
    }
}
