package gittool;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *Runnable
 * @author jelena
 */
public class DescGitHubTool implements GitHubTool, Runnable {

    private static String repoId = "https://api.github.com/repositories/";
    private int repositoryId;

    public DescGitHubTool(int repositoryId) {
        this.repositoryId = repositoryId;

    }

    /**
     *
     * @throws IOException
     * @throws JSONException
     */
    @Override
    public void runGitHubTool() {
        JSONObject object;
        try {
            object = JsonReaderUtil.readJsonFromUrl(repoId + repositoryId);
            System.out.println("name" + " " + object.get("name") + " " + "size" + " " + object.getString("size"));

        } catch (IOException ex) {
            Logger.getLogger(DescGitHubTool.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(DescGitHubTool.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void run() {

        runGitHubTool();

    }

}
