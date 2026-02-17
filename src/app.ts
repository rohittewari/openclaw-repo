import express from 'express';

export function createApp() {
  const app = express();

  app.get('/health', (_req, res) => {
    res.status(200).json({
      status: 'ok',
      service: 'openclaw-node-service'
    });
  });

  return app;
}
