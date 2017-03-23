package gittool;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jelena
 */
public class ListGitTool implements GitHubTool {

    private int x;
    private String repositories ;
    private String[] args;

    public ListGitTool(String[] args) {
        this.args = args;
        this.x = args.length > 1 ? Integer.parseInt(args[1]) : 10;
        this.repositories = "https://api.github.com/search/repositories?q=size:%3E0&page=1&per_page=" + x + "&sort=created";

    }

    @Override
    public void runGitHubTool() {
        try {

            JsonReaderUtil.readJsonArrayFromUrl(JsonReaderUtil.readJsonFromUrl(repositories));
        } catch (IOException ex) {
            Logger.getLogger(ListGitTool.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(ListGitTool.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the repositories
     */
    public String getRepositories() {
        return repositories;
    }

}
