package com.ecore.atlassian;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.atlassian.jira.ComponentManager;
import com.atlassian.jira.bc.issue.IssueService;
import com.atlassian.jira.bc.issue.IssueService.IssueResult;
import com.atlassian.jira.bc.issue.search.SearchService;
import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.event.type.EventDispatchOption;
import com.atlassian.jira.issue.Issue;
import com.atlassian.jira.issue.IssueInputParameters;
import com.atlassian.jira.issue.MutableIssue;
import com.atlassian.jira.issue.index.IndexException;
import com.atlassian.jira.issue.index.IssueIndexManager;
import com.atlassian.jira.issue.search.SearchException;
import com.atlassian.jira.jql.builder.JqlClauseBuilder;
import com.atlassian.jira.jql.builder.JqlQueryBuilder;
import com.atlassian.jira.user.ApplicationUser;
import com.atlassian.jira.util.ImportUtils;
import com.atlassian.jira.web.bean.PagerFilter;
import com.ecore.atlassian.html.HTML2WikiConverter;
import com.ecore.atlassian.html.jira.ToJIRA;

public class SummaryKeyApenderServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final Logger log = LoggerFactory.getLogger(SummaryKeyApenderServlet.class);
	private SearchService searchService;
	private IssueService issueService;
	private ApplicationUser user;

	public SummaryKeyApenderServlet(SearchService searchService, IssueService issueService) {
		this.user = ComponentAccessor.getJiraAuthenticationContext().getLoggedInUser();
		this.searchService = searchService;
		this.issueService = issueService;
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<body>");

		String projectKey = request.getParameter("project");
		int start = Integer.parseInt(request.getParameter("start"));
		int size = Integer.parseInt(request.getParameter("size"));

		int i = 0;
		
		if (projectKey != null && ComponentAccessor.getProjectManager().getProjectObjByKeyIgnoreCase(projectKey) != null) {

			if (ComponentAccessor.getGroupManager().isUserInGroup(user, "jira-administrators")) {

				List<Issue> issues = getIssues(request, projectKey, start, size);

				for (Iterator<Issue> iterator = issues.iterator(); iterator.hasNext();) {
					
					Issue issue = (Issue) iterator.next();

					String text = (String) issue.getKey();

					MutableIssue mutableIssue = ComponentAccessor.getIssueManager().getIssueObject(issue.getId());

					out.println("<p>Changing issue with key  [" + mutableIssue.getKey() + "] to [" + text + " - " + issue.getSummary() + "]</p>");

					mutableIssue.setSummary(text + " - " + issue.getSummary());

					ComponentAccessor.getIssueManager().updateIssue(user, mutableIssue, EventDispatchOption.DO_NOT_DISPATCH, false);

					out.println("<p>Done!</p>");
					
					i++;
					
				}

				out.println("<br><b><p>Changed "+ i +" issues.</p></b>");

			} else {
				out.println("You are not in group jira-administrators");
			}

		} else {
			out.println("Project key is null or not founded, please insert ?project=KEY in your URL");
		}

		out.println("</body>");
		out.println("</html>");

	}

	private List<Issue> getIssues(HttpServletRequest req, String projectKey, int start, int size) {

		JqlClauseBuilder jqlClauseBuilder = JqlQueryBuilder.newClauseBuilder();

		com.atlassian.query.Query query = jqlClauseBuilder.project(projectKey).buildQuery();

		PagerFilter pagerFilter = PagerFilter.newPageAlignedFilter(start, size);
		com.atlassian.jira.issue.search.SearchResults searchResults = null;
		try {

			searchResults = searchService.search(user, query, pagerFilter);
		} catch (SearchException e) {
			e.printStackTrace();
		}

		return searchResults.getIssues();
	}

}