const { createProxyMiddleware } = require("http-proxy-middleware");

module.exports = function (app) {
  app.use(
    [
      "/api",
      "/js",
      "/css",
      "/images",
      "/actuator",
      "/login",
      "/logout",
      "/lobby",
      "/auto-closable",
      "/run-as",
      "/run-as-me",
    ],
    createProxyMiddleware({
      target: "http://localhost:8080",
      changeOrigin: true,
      xfwd: true,
    })
  );
};
