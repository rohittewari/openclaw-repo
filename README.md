# openclaw-repo

Codebase reset for new Node.js application workflow.

Current process is managed through GitHub Issues + Project with Nancy (BA), Alex (Dev), and Casey (QA).

## Node.js service scaffold

### Prerequisites
- Node.js 20+

### Install
```bash
npm install
```

### Run in development
```bash
npm run dev
```

### Quality checks
```bash
npm run lint
npm test
```

### Health endpoint
- `GET /health`
- Example response:
```json
{ "status": "ok", "service": "openclaw-node-service" }
```
