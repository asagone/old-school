package app.back.springtemplate.controllers.Dto;

public record ResponseDto<T>(String message, T data) {
}
