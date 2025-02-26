package kr.co.nogibackend.infra.notion;

import static kr.co.nogibackend.response.code.NotionResponseCode.F_GET_BLOCK_IMAGE;
import static kr.co.nogibackend.response.code.NotionResponseCode.F_GET_NOTION_BLOCK;
import static kr.co.nogibackend.response.code.NotionResponseCode.F_GET_NOTION_PAGE;
import static kr.co.nogibackend.response.code.NotionResponseCode.F_UPDATE_TIL_STATUS;

import java.net.URI;
import java.util.Map;
import kr.co.nogibackend.config.exception.GlobalException;
import kr.co.nogibackend.domain.notion.NotionClient;
import kr.co.nogibackend.domain.notion.dto.info.NotionBlockInfo;
import kr.co.nogibackend.domain.notion.dto.info.NotionInfo;
import kr.co.nogibackend.domain.notion.dto.info.NotionPageInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class NotionClientImpl implements NotionClient {

  private final NotionFeignClient notionFeignClient;
  private final NotionImageFeignClient notionImageFeignClient;

  @Override
  public NotionInfo<NotionPageInfo> getPagesFromDatabase(
      String AuthToken,
      String databaseId,
      Map<String, Object> request
  ) {
    try {
      return
          notionFeignClient
              .getPagesFromDatabase(AuthToken, databaseId, request)
              .getBody();
    } catch (Exception error) {
      throw new GlobalException(F_GET_NOTION_PAGE);
    }
  }

  @Override
  public NotionInfo<NotionBlockInfo> getBlocksFromPage(
      String AuthToken,
      String pageId,
      String startCursor
  ) {
    try {
      return
          notionFeignClient
              .getBlocksFromPage(AuthToken, pageId, startCursor)
              .getBody();
    } catch (Exception error) {
      throw new GlobalException(F_GET_NOTION_BLOCK);
    }
  }

  @Override
  public byte[] getBlockImage(URI baseUri) {
    try {
      return notionImageFeignClient.getBlockImage(baseUri);
    } catch (Exception error) {
      throw new GlobalException(F_GET_BLOCK_IMAGE);
    }
  }

  @Override
  public NotionPageInfo updatePageStatus(
      String AuthToken
      , String pageId
      , Map<String, Object> request
  ) {
    try {
      return
          notionFeignClient
              .updatePageStatus(AuthToken, pageId, request)
              .getBody();
    } catch (Exception error) {
      throw new GlobalException(F_UPDATE_TIL_STATUS);
    }

  }

}
