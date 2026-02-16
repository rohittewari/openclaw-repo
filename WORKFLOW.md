# Delivery Workflow (BA → Dev → QA)

This repository uses **GitHub Issues + Projects** as the source of truth.

Project board: **openclaw Delivery Board**

## Status Flow

`Backlog` → `Ready` → `In Progress` → `Review` → `QA` → `Done`

## Roles & Responsibilities

### 1) BA (NancyBot-BA)

- Capture and refine requirements into a **Story issue**.
- Ensure story includes:
  - clear story statement
  - Given/When/Then acceptance criteria
  - dependencies / assumptions
  - handoff notes for Dev
- Apply labels (as needed): `Story`, `BA`, `Priority: High/Medium/Low`.
- Keep story in **Backlog** until it is fully defined.
- Move to **Ready** only when story is implementation-ready.

### 2) Developer (AlexBot-Dev)

- Pull work from **Ready**.
- Move status: `Ready` → `In Progress`.
- Branch from `main` using:
  - `feature/PROJ-123-short-desc`
- Commit format:
  - `PROJ-123: short message`
- Open PR and link issue using:
  - `Closes #<issue-number>`
- Include concise implementation notes and test notes.
- Move status to **Review** when PR is ready.

### 3) QA (CaseyBot-QA)

- Pull item from **Review** and move to **QA**.
- Build QA checklist mapped 1:1 to acceptance criteria.
- Validate PR changes.
- Post **PASS/FAIL** results with reproducible defect details:
  - expected vs actual
  - environment
  - evidence/logs if available
- If PASS: move to **Done**.
- If FAIL: move back to **In Progress** with defect comments.

## Definition of Done (DoD)

A story is **Done** only when all are true:

1. Acceptance criteria are met.
2. Lint checks pass.
3. PR is reviewed/approved (rebase policy).
4. QA validates and marks PASS.
5. Final status is set to `Done`.

## Conventions

- Base branch: `main`
- Merge policy: `rebase`
- Quality gate: `lint + PR review`
- Keep comments concise and actionable.
