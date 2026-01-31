package util;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

/** JsonLoader. */
public final class JsonLoader {

  private JsonLoader() {}

  /** loadJson. */
  public static <T> List<T> loadJson(String path, Class<T> type) throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();

    File file = new File(JsonLoader.class.getClassLoader().getResource(path).getFile());

    ObjectMapper mapper = new ObjectMapper();
    return mapper.readerForListOf(type).readValue(objectMapper.readTree(file));
  }
}
