package kr.co.nogibackend.domain.notion.dto.property;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NotionNogiCommitDateProperty extends NotionNogiCommonProperty {

  private NotionDateProperty date;

}
