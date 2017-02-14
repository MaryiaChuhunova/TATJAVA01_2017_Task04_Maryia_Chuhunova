package dao.parser;

import bean.Release;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Maria on 12.02.2017.
 */
public class ResultIntoListParser {

    public static ArrayList<Release> parseResultIntoList(ResultSet result) throws SQLException {
        ArrayList resultList = new ArrayList();
        while(result.next()) {
            resultList.add(new Release(result.getString("category"), result.getString("author"),
                    result.getString("title"), result.getString("date")));
        }
        return resultList;
    }

}
