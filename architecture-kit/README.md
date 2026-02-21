# AI Architecture Kit

Reusable kit to generate professional software architecture documentation and diagrams from prompts.

## What’s Included
- Prompt templates for BRD, TRD, HLD, LLD, and test strategy
- Document templates with consistent structure
- Diagram standards/checklist for draw.io + cloud icons
- Versioning and review workflow

## Suggested Workflow
1. Fill `prompts/project-brief.md`
2. Generate docs into `docs/`
3. Draft diagrams from `prompts/diagram-spec.md`
4. Finalize in draw.io with icon packs
5. Run review checklist before sharing

## Folder Structure
- `prompts/` → AI prompt inputs
- `templates/` → markdown templates
- `standards/` → diagram and quality standards
- `examples/` → starter examples (including AWS draw.io template)

## Naming Convention
- Docs: `BRD_v1.md`, `TRD_v1.md`, `HLD_v1.md`, `LLD_v1.md`
- Diagrams: `context_v1.drawio`, `container_v1.drawio`, `deployment_v1.drawio`, `sequence-auth_v1.drawio`

## Iteration Convention
- v1 draft
- v2 revised (after architecture review)
- v3 stakeholder-ready
