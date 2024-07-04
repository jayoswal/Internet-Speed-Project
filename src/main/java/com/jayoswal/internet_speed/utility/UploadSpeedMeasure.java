package com.jayoswal.internet_speed.utility;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class UploadSpeedMeasure {

    private static final int DATA_SIZE_MB = 1; // Data size in MB for the upload

    public static double getUploadSpeed(){
        try {
            URL url = new URL("https://httpbin.org/post"); // Replace with your upload URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setConnectTimeout(5000); // 5 seconds timeout for connection
            connection.setReadTimeout(5000); // 5 seconds timeout for reading

            // Simulate data to be uploaded
            byte[] data = new byte[DATA_SIZE_MB * 1024 * 1024]; // 100 MB data

            long startTime = System.nanoTime();

            // Upload data
            try (OutputStream outputStream = connection.getOutputStream()) {
                outputStream.write(data);
                outputStream.flush();
            }

            long endTime = System.nanoTime();
            long durationNanos = endTime - startTime;
            double durationSeconds = durationNanos / 1_000_000_000.0;

            // Calculate upload speed in Mbps
            double uploadSpeedMbps = (DATA_SIZE_MB * 8.0) / durationSeconds;

            // System.out.println("Upload Speed: " + uploadSpeedMbps + " Mbps");

            // Check response code
            int responseCode = connection.getResponseCode();
            // System.out.println("Response Code: " + responseCode);
            return uploadSpeedMbps;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
