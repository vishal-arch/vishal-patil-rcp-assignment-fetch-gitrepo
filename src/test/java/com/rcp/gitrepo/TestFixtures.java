package com.rcp.gitrepo;

import com.rcp.gitrepo.adaptor.model.GitRespositoriesEndpointResponse;
import com.rcp.gitrepo.adaptor.model.Item;
import com.rcp.gitrepo.adaptor.model.Owner;
import com.rcp.gitrepo.web.request.RepositoriesSortDirection;
import com.rcp.gitrepo.web.request.RequestCriteria;
import com.rcp.gitrepo.web.request.RespositoriesSortBy;
import com.rcp.gitrepo.web.response.Attribute;
import com.rcp.gitrepo.web.response.GitRepositoriesResponse;
import com.rcp.gitrepo.web.response.GitRespositoriesDetails;
import com.rcp.gitrepo.web.response.Link;
import com.rcp.gitrepo.web.response.RepositoryType;
import java.util.List;

public class TestFixtures {

    public static GitRespositoriesEndpointResponse createGitEnpointResponse() {

        return GitRespositoriesEndpointResponse.builder()
            .items(
                List.of(Item.builder()
                    .language("Java")
                    .fullName("Dummy Repo")
                    .description("This is a dummy description")
                    .htmlUrl("http://dummy.com")
                    .noOfStars("100")
                    .id("Dummy-id")
                    .owner(Owner.builder()
                        .avatarUrl("http://dummy-avatar")
                        .build())
                    .build()
                )
            )
            .build();
    }

    public static GitRepositoriesResponse getGitRepositoriesResponse() {
        return GitRepositoriesResponse.builder()
            .type(RepositoryType.POPULAR_GIT_REPO)
            .data(List.of(
                GitRespositoriesDetails.builder()
                    .attributes(Attribute.builder()
                        .url("http://dummy.com")
                        .stars("100")
                        .description("This is a dummy description")
                        .id("Dummy-id")
                        .language("Java")
                        .links(Link.builder()
                            .avatarLink("http://dummy-avatar")
                            .build())
                        .name("Dummy Repo")
                        .build())
                    .build()
            )).build();
    }

    public static RequestCriteria getRequestCriteria() {
        return RequestCriteria.builder()
            .sortDirection(RepositoriesSortDirection.DESC)
            .language("Java")
            .sortBy(RespositoriesSortBy.STARS)
            .topRecordsToView("100")
            .build();
    }

    public static String endpointResonse = """
        {
          "total_count": 41473,
          "incomplete_results": false,
          "items": [
            {
              "id": 100000,
              "node_id": "R_kgDOKJMusw",
              "name": "Synapse-X",
              "full_name": "GameHackers15/Synapse-X",
              "private": false,
              "owner": {
                "login": "GameHackers15",
                "id": 142716498,
                "node_id": "U_kgDOCIGuUg",
                "avatar_url": "https://avatars.githubusercontent.com/u/142716498?v=4",
                "gravatar_id": "",
                "url": "https://api.github.com/users/GameHackers15",
                "html_url": "https://github.com/GameHackers15",
                "followers_url": "https://api.github.com/users/GameHackers15/followers",
                "following_url": "https://api.github.com/users/GameHackers15/following{/other_user}",
                "gists_url": "https://api.github.com/users/GameHackers15/gists{/gist_id}",
                "starred_url": "https://api.github.com/users/GameHackers15/starred{/owner}{/repo}",
                "subscriptions_url": "https://api.github.com/users/GameHackers15/subscriptions",
                "organizations_url": "https://api.github.com/users/GameHackers15/orgs",
                "repos_url": "https://api.github.com/users/GameHackers15/repos",
                "events_url": "https://api.github.com/users/GameHackers15/events{/privacy}",
                "received_events_url": "https://api.github.com/users/GameHackers15/received_events",
                "type": "User",
                "site_admin": false
              },
              "html_url": "https://github.com/GameHackers15/Synapse-X",
              "description": null,
              "fork": false,
              "url": "https://api.github.com/repos/GameHackers15/Synapse-X",
              "forks_url": "https://api.github.com/repos/GameHackers15/Synapse-X/forks",
              "keys_url": "https://api.github.com/repos/GameHackers15/Synapse-X/keys{/key_id}",
              "collaborators_url": "https://api.github.com/repos/GameHackers15/Synapse-X/collaborators{/collaborator}",
              "teams_url": "https://api.github.com/repos/GameHackers15/Synapse-X/teams",
              "hooks_url": "https://api.github.com/repos/GameHackers15/Synapse-X/hooks",
              "issue_events_url": "https://api.github.com/repos/GameHackers15/Synapse-X/issues/events{/number}",
              "events_url": "https://api.github.com/repos/GameHackers15/Synapse-X/events",
              "assignees_url": "https://api.github.com/repos/GameHackers15/Synapse-X/assignees{/user}",
              "branches_url": "https://api.github.com/repos/GameHackers15/Synapse-X/branches{/branch}",
              "tags_url": "https://api.github.com/repos/GameHackers15/Synapse-X/tags",
              "blobs_url": "https://api.github.com/repos/GameHackers15/Synapse-X/git/blobs{/sha}",
              "git_tags_url": "https://api.github.com/repos/GameHackers15/Synapse-X/git/tags{/sha}",
              "git_refs_url": "https://api.github.com/repos/GameHackers15/Synapse-X/git/refs{/sha}",
              "trees_url": "https://api.github.com/repos/GameHackers15/Synapse-X/git/trees{/sha}",
              "statuses_url": "https://api.github.com/repos/GameHackers15/Synapse-X/statuses/{sha}",
              "languages_url": "https://api.github.com/repos/GameHackers15/Synapse-X/languages",
              "stargazers_url": "https://api.github.com/repos/GameHackers15/Synapse-X/stargazers",
              "contributors_url": "https://api.github.com/repos/GameHackers15/Synapse-X/contributors",
              "subscribers_url": "https://api.github.com/repos/GameHackers15/Synapse-X/subscribers",
              "subscription_url": "https://api.github.com/repos/GameHackers15/Synapse-X/subscription",
              "commits_url": "https://api.github.com/repos/GameHackers15/Synapse-X/commits{/sha}",
              "git_commits_url": "https://api.github.com/repos/GameHackers15/Synapse-X/git/commits{/sha}",
              "comments_url": "https://api.github.com/repos/GameHackers15/Synapse-X/comments{/number}",
              "issue_comment_url": "https://api.github.com/repos/GameHackers15/Synapse-X/issues/comments{/number}",
              "contents_url": "https://api.github.com/repos/GameHackers15/Synapse-X/contents/{+path}",
              "compare_url": "https://api.github.com/repos/GameHackers15/Synapse-X/compare/{base}...{head}",
              "merges_url": "https://api.github.com/repos/GameHackers15/Synapse-X/merges",
              "archive_url": "https://api.github.com/repos/GameHackers15/Synapse-X/{archive_format}{/ref}",
              "downloads_url": "https://api.github.com/repos/GameHackers15/Synapse-X/downloads",
              "issues_url": "https://api.github.com/repos/GameHackers15/Synapse-X/issues{/number}",
              "pulls_url": "https://api.github.com/repos/GameHackers15/Synapse-X/pulls{/number}",
              "milestones_url": "https://api.github.com/repos/GameHackers15/Synapse-X/milestones{/number}",
              "notifications_url": "https://api.github.com/repos/GameHackers15/Synapse-X/notifications{?since,all,participating}",
              "labels_url": "https://api.github.com/repos/GameHackers15/Synapse-X/labels{/name}",
              "releases_url": "https://api.github.com/repos/GameHackers15/Synapse-X/releases{/id}",
              "deployments_url": "https://api.github.com/repos/GameHackers15/Synapse-X/deployments",
              "created_at": "2023-08-20T08:14:20Z",
              "updated_at": "2023-08-20T11:19:35Z",
              "pushed_at": "2023-08-20T08:14:53Z",
              "git_url": "git://github.com/GameHackers15/Synapse-X.git",
              "ssh_url": "git@github.com:GameHackers15/Synapse-X.git",
              "clone_url": "https://github.com/GameHackers15/Synapse-X.git",
              "svn_url": "https://github.com/GameHackers15/Synapse-X",
              "homepage": "",
              "size": 5,
              "stargazers_count": 81,
              "watchers_count": 81,
              "language": null,
              "has_issues": true,
              "has_projects": true,
              "has_downloads": true,
              "has_wiki": true,
              "has_pages": false,
              "has_discussions": false,
              "forks_count": 0,
              "mirror_url": null,
              "archived": false,
              "disabled": false,
              "open_issues_count": 0,
              "license": {
                "key": "apache-2.0",
                "name": "Apache License 2.0",
                "spdx_id": "Apache-2.0",
                "url": "https://api.github.com/licenses/apache-2.0",
                "node_id": "MDc6TGljZW5zZTI="
              },
              "allow_forking": true,
              "is_template": false,
              "web_commit_signoff_required": false,
              "topics": [
                "roblox-cheat",
                "roblox-executor",
                "roblox-executor-cracked",
                "roblox-executor-free",
                "roblox-hack",
                "roblox-synapse-x-free",
                "synapse-x",
                "synapse-x-2023",
                "synapse-x-crack",
                "synapse-x-cracked",
                "synapse-x-cracked-2023",
                "synapse-x-cracked-download",
                "synapse-x-cracked-free",
                "synapse-x-download",
                "synapse-x-free",
                "synapse-x-free-download"
              ],
              "visibility": "public",
              "forks": 0,
              "open_issues": 0,
              "watchers": 81,
              "default_branch": "main",
              "score": 1.0
            }
          ]
        }
                
        """;

}
