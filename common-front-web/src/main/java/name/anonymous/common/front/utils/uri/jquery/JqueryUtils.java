package name.anonymous.common.front.utils.uri.jquery;

import org.apache.commons.lang3.StringUtils;

public class JqueryUtils {
	private JqueryUtils() {}

	public static void replaceBracket(String key, StringBuilder stringBuilder) {
		int firstOpenBracketIndex = key.indexOf('[');
		if (firstOpenBracketIndex >= 0) {
			int firstClosedBracketIndex = key.indexOf(']');
			if (firstClosedBracketIndex >= 0) {
				String beforeFirstOpenBracket = key.substring(0, firstOpenBracketIndex);
				String afterFirstClosedBracket = key.substring(firstClosedBracketIndex + 1, key.length());
				if (firstClosedBracketIndex - firstOpenBracketIndex > 1) {
						String bracketContent = key.substring(firstOpenBracketIndex + 1, firstClosedBracketIndex);
						if (!StringUtils.isNumeric(bracketContent)) {
							stringBuilder.append(beforeFirstOpenBracket).append('.').append(bracketContent);
							replaceBracket(afterFirstClosedBracket, stringBuilder);
							return;
						}
				}
				String betweenBracket = key.substring(firstOpenBracketIndex, firstClosedBracketIndex + 1);
				stringBuilder.append(beforeFirstOpenBracket).append(betweenBracket);
				replaceBracket(afterFirstClosedBracket, stringBuilder);
				return;
			}
		}
		stringBuilder.append(key);
	}
}
