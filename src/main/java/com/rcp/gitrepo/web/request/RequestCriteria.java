package com.rcp.gitrepo.web.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class RequestCriteria {


    private String language;
    private String dateFrom;
    private String topRecordsToView;

    private RespositoriesSortBy sortBy;
    private RepositoriesSortDirection sortDirection;

}
