#version 330

in vec3 textureCoords;

out vec4 out_color;

uniform samplerCube cubeMap;
uniform samplerCube cubeMap2;
uniform float blendFactor;

const float lowerLimit = 0.0;
const float upperLimit = 30.0;

void main() {
    vec4 texture1 = texture(cubeMap, textureCoords);
    vec4 texture2 = texture(cubeMap2, textureCoords);
    out_color = mix(texture1, texture2, blendFactor);
    //    out_color = texture(cubeMap, textureCoords);
}