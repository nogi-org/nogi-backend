package kr.co.nogibackend.interfaces.guide;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.nogibackend.domain.guide.GuideService;
import kr.co.nogibackend.domain.guide.dto.request.GuideRegisterRequest;
import kr.co.nogibackend.domain.guide.dto.request.GuideUpdateRequest;
import kr.co.nogibackend.response.service.Response;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/guide")
@RequiredArgsConstructor
public class GuideController {

	private final GuideService guideService;

	@PostMapping
	public ResponseEntity<?> registerGuide(@Validated @RequestBody GuideRegisterRequest request) {
		return Response.success(guideService.registerGuide(request.toCommand()));
	}

	@GetMapping("/list")
	public ResponseEntity<?> getGuides() {
		return Response.success(guideService.getGuides());
	}

	@PutMapping
	public ResponseEntity<?> updateGuide(@Validated @RequestBody GuideUpdateRequest request) {
		return Response.success(guideService.updateGuide(request.toCommand()));
	}

	@DeleteMapping
	public ResponseEntity<?> deleteGuide(@RequestParam("id") Long guideId) {
		return Response.success(guideService.deleteGuide(guideId));
	}

}
