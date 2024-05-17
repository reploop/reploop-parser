package org.reploop.translator.json.driver;

import org.reploop.translator.json.support.Target;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;
import java.util.StringJoiner;

public class Json2Conf {
  /**
   * Process all json file in the input directory.
   */
  private final List<String> inputDirectories = new ArrayList<>();
  /**
   * An uri to specify where the JSON is. It's schema should be a file, http or https, we can handle each of them differently.
   */
  private final List<String> uris = new ArrayList<>();
  /**
   * Support targets.
   */
  private final EnumSet<Target> targets = EnumSet.noneOf(Target.class);
  /**
   * Where the source code should go
   */
  private String outputDirectory;
  /**
   * Try to guess a reasonable root name from the filename or the API uri given, otherwise $ is used by default.
   */
  private Boolean enableRootGuess = true;
  /**
   * Fail if any error occurred. Default true.
   */
  private Boolean enableFailFast = true;
  /**
   * If it's json5
   */
  private Boolean json5 = false;
  /**
   * The top package or namespace of the source. Add package line to the source. Default is empty.
   */
  private String namespace;

  public String getOutputDirectory() {
    return outputDirectory;
  }

  public Json2Conf outputDirectory(String outputDirectory) {
    this.outputDirectory = outputDirectory;
    return this;
  }

  public List<String> getInputDirectories() {
    return inputDirectories;
  }

  public Json2Conf inputDirectory(String inputDirectory) {
    return addOne(inputDirectory, inputDirectories);
  }

  public Json2Conf inputDirectories(List<String> inputDirectories) {
    return addMany(inputDirectories, this.inputDirectories);
  }

  public EnumSet<Target> getTargets() {
    return targets;
  }

  public Json2Conf target(Target target) {
    return addOne(target, targets);
  }

  public Json2Conf targets(EnumSet<Target> targets) {
    return addMany(targets, this.targets);
  }

  public List<String> getUris() {
    return uris;
  }

  public Json2Conf uri(String uri) {
    return addOne(uri, this.uris);
  }

  private <T> Json2Conf addMany(Collection<T> many, Collection<T> coll) {
    if (null != many) {
      coll.addAll(many);
    }
    return this;
  }

  private <T> Json2Conf addOne(T one, Collection<T> coll) {
    if (null != one) {
      coll.add(one);
    }
    return this;
  }

  public Json2Conf uris(List<String> uris) {
    return addMany(uris, this.uris);
  }

  public Boolean getEnableRootGuess() {
    return enableRootGuess;
  }

  public Json2Conf enableRootGuess(Boolean enableRootGuess) {
    this.enableRootGuess = enableRootGuess;
    return this;
  }

  public Boolean getEnableFailFast() {
    return enableFailFast;
  }

  public Json2Conf enableFailFast(Boolean enableFailFast) {
    this.enableFailFast = enableFailFast;
    return this;
  }

  public String getNamespace() {
    return namespace;
  }

  public Json2Conf namespace(String namespace) {
    this.namespace = namespace;
    return this;
  }

  public Json2Conf json5(Boolean json5) {
    this.json5 = json5;
    return this;
  }

  public Boolean getJson5() {
    return json5;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Json2Conf.class.getSimpleName() + "[", "]")
      .add("outputDirectory='" + outputDirectory + "'")
      .add("inputDirectories=" + inputDirectories)
      .add("uris=" + uris)
      .add("enableRootGuess=" + enableRootGuess)
      .add("enableFailFast=" + enableFailFast)
      .add("namespace='" + namespace + "'")
      .add("json5='" + json5 + "'")
      .toString();
  }
}
