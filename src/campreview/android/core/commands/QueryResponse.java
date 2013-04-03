package campreview.android.core.commands;

import java.util.List;

public class QueryResponse<T> {

    private List<T> results;

    public QueryResponse(List<T> results){

        this.results = results;
    }

    public List<T> getResults(){
        return results;
    }
}
