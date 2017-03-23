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
public class ListRubyGitTool implements GitHubTool {

    private int x;
    private String ruby;
    private String[] args;

    public ListRubyGitTool(String[] args) {
        this.args = args;
        this.x = args.length > 2 ? Integer.parseInt(args[2]) : 10;
        this.ruby = "https://api.github.com/search/repositories?q=language:ruby&page=1&per_page=" + x + "&sort=created";
    }

    @Override
    public void runGitHubTool() {
       
            
        try {
            JsonReaderUtil.readJsonArrayFromUrl(JsonReaderUtil.readJsonFromUrl(ruby));
        } catch (IOException ex) {
            Logger.getLogger(ListRubyGitTool.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(ListRubyGitTool.class.getName()).log(Level.SEVERE, null, ex);
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
}
