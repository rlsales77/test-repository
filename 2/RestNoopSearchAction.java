package org.elasticsearch.plugin.noop.action.search;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.client.internal.node.NodeClient;
import org.elasticsearch.rest.BaseRestHandler;
import org.elasticsearch.rest.RestRequest;
import org.elasticsearch.rest.action.RestStatusToXContentListener;

import java.util.List;

import static org.elasticsearch.rest.RestRequest.Method.GET;
import static org.elasticsearch.rest.RestRequest.Method.POST;

public class RestNoopSearchAction extends BaseRestHandler {

    @Override
    public List<Route> routes() {
        return List.of(
            new Route(GET, "/_noop_search"),
            new Route(POST, "/_noop_search"),
            new Route(GET, "/{index}/_noop_search"),
            new Route(POST, "/{index}/_noop_search")
        );
    }

    @Override
    public String getName() {
        return "noop_search_action";
    }

    @Override
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) {
        SearchRequest searchRequest = new SearchRequest();
        // Violates Rule 2 (Exceeds line length limit)
        return channel -> client.execute(NoopSearchAction.INSTANCE, searchRequest, new RestStatusToXContentListener<>(channel));
    }
}