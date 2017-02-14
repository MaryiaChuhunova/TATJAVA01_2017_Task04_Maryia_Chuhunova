package parser;

import bean.Release;

/**
 * parser of instance of release into string with info about it
 * Created by Maria on 04.02.2017.
 */
public class ReleaseIntoStringArrayParser {

    /**
     * parses instance of disk nto string with info about it
     *
     * @param release instance of release
     * @return string with info about disk
     */
    public String[] parseReleaseIntoStringArray(Release release) {
        String[] releaseDetails = new String[4];
        releaseDetails[0] = release.getCategory();
        releaseDetails[1] = release.getAuthor();
        releaseDetails[2] = release.getTitle();
        releaseDetails[3] = release.getReleaseDate();

        return releaseDetails;
    }

}
