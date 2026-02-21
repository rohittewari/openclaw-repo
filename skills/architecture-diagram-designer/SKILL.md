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

### Runtime override examples
- "Use architecture-diagram-designer with AWS icons."
- "Use architecture-diagram-designer with Azure icons."
- "Generate draft only, then wait for my approval before finalizing diagrams."

Use shared icon resources from:
- `shared-resources/aws-icons/` (primary for AWS diagrams)
- `shared-resources/drawio-icons/` (native draw.io helpers: arrows/flowchart/common)
- `shared-resources/azure-icons/` (when available)

Icon usage policy:
1) If diagram mode is AWS, prioritize icons from `shared-resources/aws-icons/`.
2) Use `shared-resources/drawio-icons/` only where appropriate (generic connectors, flow helpers, non-cloud symbols).
3) Keep icon style consistent within a diagram.

## Process
1) Parse requirement/HLD/LLD
2) Propose diagram list and flow
3) Generate draft `.drawio`
4) Ask for review and refine routing/layout/labels
5) Save final diagram artifacts

Keep connectors labeled and include trust boundaries where relevant.
