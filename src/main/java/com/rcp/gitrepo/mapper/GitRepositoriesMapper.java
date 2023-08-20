package com.rcp.gitrepo.mapper;


import com.rcp.gitrepo.adaptor.model.GitRespositoriesEndpointResponse;
import com.rcp.gitrepo.adaptor.model.Item;
import com.rcp.gitrepo.adaptor.model.Owner;
import com.rcp.gitrepo.web.response.GitRepositoriesResponse;
import com.rcp.gitrepo.web.response.GitRespositoriesDetails;
import com.rcp.gitrepo.web.response.Link;
import com.rcp.gitrepo.web.response.RepositoryType;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * The mapper class has methods for mapping from Git hub endpoint response to Web response.
 */
@Mapper(imports = {RepositoryType.class})
public interface GitRepositoriesMapper {

    GitRepositoriesMapper INSTANCE = Mappers.getMapper(GitRepositoriesMapper.class);

    @Mapping(target = "avatarLink", source = "avatarUrl")
    Link fromOwner(Owner owner);

    @Mapping(target = "attributes.id", source = "id")
    @Mapping(target = "attributes.name", source = "fullName")
    @Mapping(target = "attributes.description", source = "description")
    @Mapping(target = "attributes.url", source = "htmlUrl")
    @Mapping(target = "attributes.stars", source = "noOfStars")
    @Mapping(target = "attributes.language", source = "language")
    @Mapping(target = "attributes.links", source = "owner")
    GitRespositoriesDetails fromItem(Item item);

    List<GitRespositoriesDetails> fromItems(List<Item> items);

    @Mapping(target = "data", source = "items")
    @Mapping(target = "type", expression = "java(RepositoryType.POPULAR_GIT_REPO)")
    GitRepositoriesResponse mapToGitRepositoriesResponse(
        GitRespositoriesEndpointResponse gitRespositoriesEndpointResponse);


}
