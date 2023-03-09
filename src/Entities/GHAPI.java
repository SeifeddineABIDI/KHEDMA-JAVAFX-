/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.File;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.commons.io.FileUtils;
import org.kohsuke.github.GHContentBuilder;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;

/**
 *
 * @author azers
 */
public class GHAPI {
    
    private static final String ACCESS_TOKEN = "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";
    private static final String REPO_OWNER = "Azer-prog";
    private static final String REPO_NAME = "TestAPI";

    /*public static void main(String[] args) throws Exception {
        GitHub github = new GitHubBuilder().withOAuthToken(ACCESS_TOKEN).build();
        GHRepository repo = github.getRepository(REPO_OWNER + "/" + REPO_NAME);
       
        String filePath = "testing1.txt";
        String fileContent = "TEEEEEST";
        
        // Read the contents of the file into a string
        //String fileContent = FileUtils.readFileToString(file, "UTF-8");

        GHContentBuilder builder = repo.createContent();
        builder.path(filePath).content(fileContent).message("Test commit").commit();
    }*/
        public static void createFileInFolderInRepo(String filePath, String folderPath) throws Exception {
    GitHub github = new GitHubBuilder().withOAuthToken(ACCESS_TOKEN).build();
    GHRepository repo = github.getRepository(REPO_OWNER + "/" + REPO_NAME);

    GHContentBuilder builder = repo.createContent();

    // Create the full path of the file, including the folder
    String fullPath = folderPath + "/" + new File(filePath).getName();

    // Read the file content
    String fileContent = FileUtils.readFileToString(new File(filePath), "UTF-8");

    // Create the file content in the specified folder
    builder.path(fullPath).content(fileContent).message("Task commit").commit();
}
        public static void createFolderInRepo(String folderPath) throws Exception {
    GitHub github = new GitHubBuilder().withOAuthToken(ACCESS_TOKEN).build();
    GHRepository repo = github.getRepository(REPO_OWNER + "/" + REPO_NAME);

    GHContentBuilder builder = repo.createContent();
    builder.path(folderPath + "/.gitkeep").content("").message("Create folder").commit();
}
        
        
public static void inviteCollaboratorByEmail(String email, String permission) throws Exception {
    String apiUrl = "https://api.github.com/repos/" + REPO_OWNER + "/" + REPO_NAME + "/collaborators/" + email;
    URL url = new URL(apiUrl);

    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setRequestMethod("PUT");
    conn.setRequestProperty("Authorization", "token " + ACCESS_TOKEN);
    conn.setRequestProperty("Accept", "application/vnd.github.v3+json");
    conn.setRequestProperty("Content-Type", "application/json");

    String requestBody = "{\"permission\":\"" + permission + "\"}";
    conn.setDoOutput(true);
    OutputStream os = conn.getOutputStream();
    os.write(requestBody.getBytes());
    os.flush();
    os.close();

    int responseCode = conn.getResponseCode();
    if (responseCode == HttpURLConnection.HTTP_CREATED) {
        System.out.println("Collaborator invitation sent successfully.");
    } else {
        String responseMessage = conn.getResponseMessage();
        System.err.println("Error sending collaborator invitation: " + responseMessage);
        System.out.println(apiUrl);
    }
    conn.disconnect();
}


}
