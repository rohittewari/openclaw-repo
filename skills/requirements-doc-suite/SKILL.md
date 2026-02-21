---
name: requirements-doc-suite
description: Generate and refine software requirements documentation from an idea or draft requirement. Use when the user asks for BRD, FRD, TRD, HLD, LLD, requirement refinement, approval-gated document generation, or phased documentation review.
---

# Requirements Doc Suite

Create docs in this order unless the user asks otherwise:
1) Requirement Definition (refinement)
2) BRD
3) FRD
4) TRD
5) HLD
6) LLD

## Approval Gates
- Gate 1 (mandatory): ask for approval after Requirement Definition.
- Gate 2 (optional): ask for approval after HLD before creating LLD.
- If user says "approval after every document", pause after each document.

### Runtime override examples
- "Use requirements-doc-suite with approval after every document."
- "Run requirements-doc-suite with Gate 2 off."
- "Run requirements-doc-suite and pause only at Gate 1 and Gate 2."

## Inputs to collect
- Business goal and success metrics
- Users/stakeholders
- Scope / out-of-scope
- Constraints (time, budget, compliance)
- Non-functional requirements
- Preferred cloud/stack (if known)

## Output files (default)
Write under a project folder:
- BRD.md
- FRD.md
- TRD.md
- HLD.md
- LLD.md

Use concise, implementation-ready language with assumptions + open questions sections.
