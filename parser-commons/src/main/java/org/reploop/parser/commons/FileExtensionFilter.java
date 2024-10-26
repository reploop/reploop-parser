package org.reploop.parser.commons;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FilenameFilter;
import java.util.HashSet;
import java.util.Set;

/**
 * What's this about?
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2015-03-06 09
 */
public class FileExtensionFilter implements FilenameFilter {

	private static final Logger LOG = LoggerFactory.getLogger(FileExtensionFilter.class);

	private final Set<String> extensions = new HashSet<>();

	private static final String DOT = ".";

	public FileExtensionFilter(String... extensions) {
		for (String ext : extensions) {
			this.extensions.add(ext.toLowerCase());
		}
	}

	public boolean accept(String name) {
		return accept(null, name);
	}

	@Override
	public boolean accept(File dir, String name) {
		if (null == name) {
			return false;
		}
		int idx = name.lastIndexOf(DOT);
		if (-1 == idx) {
			return false;
		}
		String extension = name.substring(idx + 1).toLowerCase();
		return extensions.contains(extension);
	}

}
