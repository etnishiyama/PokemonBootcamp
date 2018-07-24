package br.inatel.pokemonbootcamp.util;

/**
 * Logger class util to help application logging.
 *
 * @author Everton Takashi Nishiyama <evertontn@inatel.br>
 * @since 20/07/2018.
 */
public class Logger {

  public static final boolean DEBUG = true;

  private static final int MAX_TAG_LENGTH = 23;

  private static final int CLASS_STACK_ITEM = 3;

  /**
   * Returns A TAG for the caller class.
   *
   * @return The Tag to be used for logs.
   */
  public static String getTag() {
    final StackTraceElement caller = Thread.currentThread().getStackTrace()[CLASS_STACK_ITEM];
    String tag = caller.getClassName();
    final int lastDot = tag.lastIndexOf('.');

    if (lastDot > 0) {
      tag = tag.substring(lastDot + 1);
    }

    if (tag.length() > MAX_TAG_LENGTH) {
      tag = tag.substring(0, MAX_TAG_LENGTH);
    }

    return tag;
  }
}
