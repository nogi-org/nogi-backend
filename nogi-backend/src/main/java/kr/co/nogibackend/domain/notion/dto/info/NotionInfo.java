package kr.co.nogibackend.domain.notion.dto.info;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NotionInfo<T> {

  private String object;
  private List<T> results;
  private String next_cursor;
  private boolean has_more;
  private String type;
  private Object block;

  public static <T> NotionInfo<T> empty() {
    NotionInfo<T> response = new NotionInfo<>();
    response.setResults(new ArrayList<>());
    response.setHas_more(false);
    return response;
  }

}
