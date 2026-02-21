---
name: architecture-diagram-designer
description: Create professional architecture and design diagrams from requirements/HLD/LLD. Use when the user asks for draw.io diagrams, architecture visuals, AWS/Azure icon-based diagrams, or diagram refinement from existing docs.
---

# Architecture Diagram Designer

Generate draw.io diagrams from requirement docs and/or HLD/LLD.

## Diagram set (default)
1) Context diagram
2) Container diagram
3) Deployment diagram
4) Sequence diagram for critical flow
5) Data-flow diagram

## Icon provider selection
Always ask if not specified:
- AWS
- Azure
(Default: AWS)

Use shared icon seed files from:
- `shared-resources/aws-icons/`
- `shared-resources/azure-icons/` (when available)

## Process
1) Parse requirement/HLD/LLD
2) Propose diagram list and flow
3) Generate draft `.drawio`
4) Ask for review and refine routing/layout/labels
5) Save final diagram artifacts

Keep connectors labeled and include trust boundaries where relevant.
