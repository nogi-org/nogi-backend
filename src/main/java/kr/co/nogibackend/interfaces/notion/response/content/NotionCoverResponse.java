package kr.co.nogibackend.interfaces.notion.response.content;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotionCoverResponse {

  private String type;
  private NotionExternalResponse external;

}
