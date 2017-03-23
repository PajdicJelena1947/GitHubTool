package gittool;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Strategy pattern
 * @author jelena
 */
public class Strategy {

    public GitHubTool getTool(String gitType, String[] args) {
        if (gitType == null) {
            return null;
        }
        if (gitType.equals(StaticVariables.list)) {
            return new ListGitTool(args);

        } else if (gitType.equals(StaticVariables.listRuby)) {
            return new ListRubyGitTool(args);
        }
        return null;
    }
}
