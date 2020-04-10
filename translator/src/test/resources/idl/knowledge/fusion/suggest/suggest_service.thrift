namespace java com.qiyi.knowledge.suggest.service

service SuggestService {
    binary suggestQuery(1: binary suggest_query_request);
    binary suggestQueryPlus(1: binary suggest_query_plus_request);
}